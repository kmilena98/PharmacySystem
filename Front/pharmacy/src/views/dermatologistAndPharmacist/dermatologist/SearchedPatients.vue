<template>

  <div>
  <notifications animation-type="velocity"/>
   <b-modal ref="my-modal" hide-footer title="Unesite zeljeni termin">
            <div class="d-block text-center">
              <b-row>
                <b-col sm="3">
                  <b-form-input type="date" v-model="date"></b-form-input>
                </b-col>
                <b-col sm="3">
                  <b-form-input type="time" v-model="time"></b-form-input>
                </b-col>
              </b-row>
            </div>
            <b-row>
              <b-col>
                <b-button
                  class="mt-3"
                  variant="outline-primary"
                  block
                  @click="hideModal"
                  >Close</b-button
                >
              </b-col>
              <b-col>
                <b-button
                  class="mt-3"
                  variant="success"
                  block
                  @click="submitModal"
                  >Submit</b-button
                >
              </b-col>
            </b-row>
          </b-modal>
  <h4>Izaberite pacijenta za kojeg ce se vrsiti pregled</h4>
   <b-input-group prepend="Prezime i ime" class="mt-3">
    <b-form-input v-model="imeIPrezime"></b-form-input>
    <b-input-group-append>
      <b-button variant="info" v-on:click="search(imeIPrezime)">Pretrazi</b-button>
    </b-input-group-append>
  </b-input-group>
     <b-table
            primary-key="id"
            
            :items="items"
            :fields="Fields"
           :select-mode="selectMode"
            responsive="sm"
            ref="selectableTable"
            selectable
             @row-selected="onRowSelected"
          ></b-table>
  </div>
  
</template>

<script>
export default {
    data(){
       return{ items : [],
        Fields: [
        { key: "name" , sortable: true },
        { key: "surname", sortable: true },
      ],
                imeIPrezime : ''};
    },
     created() {
  // GET request using axios with error handling
   this.$axios.get("http://localhost:9001/patient/patientBySurnameAndName/*")
            .then(response => this.items = response.data)
            .catch(error => {
            this.errorMessage = error.message;
            console.error("There was an error!", error);});
    },methods: {
        search: function(imeIPrezime){
           if(imeIPrezime.trim() === "")
                {
                    imeIPrezime = "*"
                }

            this.$axios.get("http://localhost:9001/patient/patientBySurnameAndName/"+ imeIPrezime)
            .then(response => { this.items = response.data
            if(response.data.length === 0){
                 this.$notify({  
                type: "info",
                title: 'Empty',
                text: ' Nema trazenih korisnika!',
                closeOnClick : true
            });
            }})
            .catch(() => {
            this.$notify({
                 type: "error",
                title: 'Error',
                text: 'Doslo je do greske prilikom poziva!',              
                closeOnClick : true
            });
        })},
        subtract: function(dec){
            this.age -= dec;
        },
        updateXY: function(event){
            this.x = event.offsetX;
            this.y = event.offsetY;
        },onRowSelected(items) {
         
        this.selected = items
           this.$axios
        .post("http://localhost:9001/examination/saveExamination", {
          currentExaminationId: 4,
          newExaminationId : items[0].examinationId
        })
        .then((response) => {
          this.message = response.data;
          if (response.status == 200) {
             this.open()
             
            this.$notify({
              type: "success",
              title: "Success",
              text: this.message,
              closeOnClick: true,
            });
          }else{
            this.$notify({
              type: "error",
              title: "Error",
              text: "Ovaj pacijent nema trenutno zakazan pregled",
              closeOnClick: true,
            });
          }
        })
         this.getDefExaminations(items[0])
      }, open: function() {
            this.$refs["my-modal"].show();
        }, hideModal: function() {
          this.$refs["my-modal"].hide();
        }, 
    }
}
</script>

