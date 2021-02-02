<template>
  <div>
    <b-table striped hover :items="items"></b-table>
  </div>
</template>

<script>
export default {
    data(){
       return{ items : []};
    },
     created() {
  // GET request using axios with error handling
  this.$axios.get("http://localhost:9001/api/patientBySurname/pera")
    .then(response => this.items = response.data)
    .catch(error => {
      this.errorMessage = error.message;
      console.error("There was an error!", error);
    });
}
}
</script>

