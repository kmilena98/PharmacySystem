<template>
  <div class="allergy-modal">
      <b-button 
                variant="success"
                size="sm"
                class="float-left"
                @click="openModal">
                <b-icon-plus></b-icon-plus>
                Dodaj alergiju
    </b-button>

    <b-modal id="allergy" hide-footer title="Dodaj alergiju na lek">
        <b-form>
            <b-form-select v-model="selected" :options="options" class="mb-3"></b-form-select>

            <b-button @click="addAllergy" block variant="success">
                Dodaj alergiju
            </b-button>

            <b-button @click="closeModal" block variant="danger">
                Otkaži
            </b-button>

            <!--<b-button class="mt-3" variant="outline-danger" block @click="hideModal">Close Me</b-button>
            <b-button class="mt-2" variant="outline-warning" block @click="toggleModal">Toggle Me</b-button>-->
        </b-form>
    </b-modal>
  </div>
</template>

<script>
export default {
    data(){
        return{
            selected: null,
            options: []
        }
    },
    methods: {
        addAllergy: function(){
            if(this.selected != null){
                this.$http
                    .post('patient/allergies/' + this.selected)
                    .then( () => {
                        this.toast()
                        this.closeModal()
                    })
            }            
        },
        toast(){
            this.$bvToast.toast(`Uspešno ste dodali alergiju!`, {
                title: 'Uspešno!',
                variant: 'success',
                autoHideDelay: 5000
            })
        },
        openModal(){
            this.$bvModal.show('allergy')
        },
        closeModal(){
            this.$bvModal.hide('allergy')
        }
    },
    mounted(){
        this.$http
            .get('drug')
            .then( (res) => {
                if(res.status == 200){
                    this.options = []
                    this.options.push({
                            value: null,
                            text: 'Izaberite lek'
                        })
                    res.data.forEach(drug => {
                        this.options.push({
                            value: drug.id,
                            text: drug.name
                        })
                    });
                }
            })
    }
}
</script>