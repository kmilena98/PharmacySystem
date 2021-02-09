<template>
  <div id="drugs-table">
        <b-table id = "table" striped hover primary-key="id" :tbody-transition-props="transProps" :items="items" :fields="fields"></b-table>
  </div>
</template>
<script>
export default {
  data() {
    return {
      fields: [   
        { key: "name", sortable: true },
        { key: "code", sortable: true },
        { key: "type", sortable: true },
        { key: "shape", sortable: true },
        { key: "manifacturer", sortable: true },
        { key: "loyaltyPoints", sortable: true },
      ],
      transProps: {
        name: "flip-list"
      },
      items: []
    };
  },created() {
            // GET request for examination information
            this.$axios.get("drugs/")
            .then(response => {                
                this.items = response.data;
            
            })
            .catch(error => {
            this.errorMessage = error.message;
            console.error("There was an error!", error);});}
};
</script>
<style>
table .flip-list-move {
  transition: transform 1s;
}
table {
     margin-top: 30px;
}

</style>