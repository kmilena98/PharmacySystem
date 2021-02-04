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
      <h3><b>Istorija poseta dermatologu</b></h3>
 
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
       <div v-for="(item, index) in allDrugs" :key="item">
         <input v-model="item.name" >
         <button v-on:click="add(item,index)">Dodaj</button>
        </div>
    </b-col>

     <b-col>
        <h4><b>Lekovi za terapiju</b></h4>
         <div v-for="(item, index) in therapy" :key="item">
         <input v-model="item.name" >
         <button v-on:click="subtract(item,index)">Ukloni</button>
        </div>
    </b-col>
    
  </b-row>
  <b-row class="col-md-2">
<label></label>
  </b-row>
  <b-row >
  <b-col >
     <b-button variant="info" v-on:click="submit()">SUBMIT INFORMACIJA O PREGLEDU</b-button>
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
                examinationId :0,
                items: [],
                allDrugs : [],
                text : '',
                therapy : []                
               };
    },
     created() {
            // GET request for examination information
            this.$axios.get("http://localhost:9001/examination/soonestExamination/"+1)
            .then(response => {this.examination = response.data
                                this.n = this.examination.soonestExamination.patientName
                                this.surname = this.examination.soonestExamination.patientSurname
                                this.start = this.examination.soonestExamination.examinationStart
                                this.items = this.examination.historyExaminations
                                this.examinationId = this.examination.soonestExamination.id
                                this.allDrugs = this.examination.drugsForPatient
                                })
            .catch(error => {
            this.errorMessage = error.message;
            console.error("There was an error!", error);});
            
        
    },methods: {
        add : function(item,index){
         this.therapy.push(item)
         this.allDrugs.splice(index, 1);
         console.log(item)
        },
        subtract: function(item,index){
            this.allDrugs.push(item)
         this.therapy.splice(index, 1);
        },
        submit : function(){
           
            const headers = { 
                "Authorization": "Bearer my-token",
                "My-Custom-Header": "foobar"
            };
            this.$axios.post("https://reqres.in/examination/updateExamination", {id: this.examinationId, diagnosis: this.text, drugs : this.therapy}, { headers })
                .then(response => (this.articleId = response.data.id));
        }
    }
}
</script>