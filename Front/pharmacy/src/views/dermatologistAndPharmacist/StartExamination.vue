<template>
<div>
<b-container class="bv-example-row"  >

  <b-row>
    <b-col>
    <h3><b> Podaci o pregledu</b></h3>
  <b-card>
      <b-form-group
        label="Ime pacijenta :"
        label-for="nested-street"
        label-cols-sm="3"
        label-align-sm="right"
      >
        <input
        v-model="n">
      </b-form-group>

      <b-form-group
        label="Prezime pacijenta :"
        label-for="nested-city"
        label-cols-sm="3"
        label-align-sm="right"
      >
        <input
        v-model="surname">
      </b-form-group>

      <b-form-group
        label="Vreme pocetka pregleda :"
        label-for="nested-state"
        label-cols-sm="3"
        label-align-sm="right"
      >
         <input
        v-model="start">
      </b-form-group>
      </b-card>
 </b-col>
  <b-col>
      <h3><b>Lista poseta dermatologu</b></h3>
 
       <b-table striped hover :items="items"></b-table>
  </b-col>
 </b-row>
</b-container>
  


<b-container class="bv-example-row">
  <b-row>
    <b-col>
     
    <h4><b>Postavi dijagnozu</b></h4>
       <b-form-textarea
            id="textarea"
            v-model="text"
            placeholder="Unesi text..."
            rows="5"
            max-rows="10">
       </b-form-textarea>

    </b-col>
    <b-col>
        <h4><b>Lista lekova</b></h4>
        <b-table striped hover :allDrugs="allDrugs"></b-table>
    </b-col>
     <b-col>
        <h4><b>Lista izabranih lekova</b></h4>
        <b-table striped hover :allDrugs="allDrugs"></b-table>
    </b-col>
  </b-row>
</b-container>



</div>
</template>

<script>
export default {
    data(){
       return{ 
                 n : '',
                surname : '',
                start :'',
                diagnosis : '',
                items: [],
                allDrugs : [],
               
                therapy : []};
    },
     created() {
  // GET request using axios with error handling
   this.$axios.get("http://localhost:9001//examination/soonestExamination/1")
            .then(response => {this.examination = response.data
                                this.n = this.examination.patientName
                                this.surname = this.examination.patientSurname
                                this.start = this.examination.examinationStart
                                })
            .catch(error => {
            this.errorMessage = error.message;
            console.error("There was an error!", error);});
    }
}
</script>