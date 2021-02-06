<template>
    <div class="container">
        <h4 class="h4 align-middle my-4">Profil korisnika</h4>
        
        <b-row>
            <b-col>
                 <div id="app">
                  <b-table primary-key="id" :tbody-transition-props="transProps" :items="definedExaminations" :fields="Fields"></b-table>
                 </div>
            </b-col>

            <b-col>
                <div>
                    <b-button v-on:click="open()" variant="outline-primary" >Unesite drugi termin</b-button>
                    <b-modal ref="my-modal" hide-footer title="Specifinacija leka">
                        <div class="d-block text-center">
                            <b-row >
                                <b-col sm="3">
                                <b-form-input  type="date" v-model="mydate" ></b-form-input>
                                </b-col>
                                <b-col sm="3">
                                <b-form-input  type="time" v-model="mydate" ></b-form-input>
                                </b-col>
                            </b-row>
                        </div>
                        <b-row>
                            <b-col>
                                <b-button class="mt-3" variant="outline-primary" block @click="hideModal">Close</b-button>
                            </b-col>
                            <b-col>
                                <b-button class="mt-3" variant="success" block @click="hideModal">Submit</b-button>
                            </b-col>
                        </b-row>
                    </b-modal>                   
                </div>
            </b-col>

        </b-row>
    </div>
</template>

<script>
export default{
    data(){
        return{
            Fields:[ { key: "examinationStart", sortable: true },
                     { key: "price", sortable: true }],
            definedExaminations:[]
                    }
    },created() {
            // GET request for examination information
            this.$axios.get("http://localhost:9001/examination/definedExaminations/"+4)
            .then(response => {this.definedExaminations = response.data})
            .catch(error => {
            this.errorMessage = error.message;
            console.error("There was an error!", error);});    
    },methods: {
        open : function(){
         this.$refs['my-modal'].show()
    }
    }
}
</script>