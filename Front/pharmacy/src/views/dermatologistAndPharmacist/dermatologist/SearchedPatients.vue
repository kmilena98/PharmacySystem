<template>

  <div>
  <notifications animation-type="velocity"/>
   <b-input-group prepend="Prezime i ime" class="mt-3">
    <b-form-input v-model="imeIPrezime"></b-form-input>
    <b-input-group-append>
      <b-button variant="info" v-on:click="search(imeIPrezime)">Pretrazi</b-button>
    </b-input-group-append>
  </b-input-group>
    <b-table striped hover :items="items"></b-table>
  </div>
  
</template>

<script>
export default {
    data(){
       return{ items : [],
                imeIPrezime : ''};
    },
     created() {
  // GET request using axios with error handling
   this.$axios.get("http://localhost:9001/api/patientBySurnameAndName/*")
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

            this.$axios.get("http://localhost:9001/api/patientBySurnameAndName/"+ imeIPrezime)
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
        }
    }
}
</script>

