<template>
    <div class="patient-information">
        <b-row>
            <b-col cols="8">
                <b-form>
                    <b-form-group id="name-group" label="Ime:" label-for="name-input" class="text-left">
                        <b-form-input
                            id="name-input"
                            v-model="form.name"
                            placeholder="Unesite ime"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <b-form-group id="surname-group" label="Prezime:" label-for="surname-input" class="text-left">
                        <b-form-input
                            id="surname-input"
                            v-model="form.surname"
                            placeholder="Unesite prezime"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <b-form-group id="address-group" label="Adresa, grad, država:" label-for="address-input" class="text-left">
                        <b-form-input
                            id="address-input"
                            v-model="form.address"
                            placeholder="Unesite adresu, grad, državu"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <b-form-group id="phone-group" label="Broj telefona:" label-for="phone-input" class="text-left">
                        <b-form-input
                            id="phone-input"
                            v-model="form.phoneNumber"
                            placeholder="Unesite broj telefona"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <div class="buttons text-left">                        
                        <b-button @click="onSubmit" variant="success" class="mr-2">
                            <b-icon-check></b-icon-check>
                            Izmeni informacije</b-button>
                        <b-button @click="onCancel" variant="danger">
                            <b-icon-x></b-icon-x>
                            Otkaži
                        </b-button>
                    </div>
                </b-form>
            </b-col>

            <b-col class="text-right">                
                <ChangePasswordModal />    
            </b-col>
        </b-row>
    </div>
</template>

<script>
import ChangePasswordModal from './ChangePasswordModal.vue';

export default {
    props: ['user'],
    data() {
        return {
            form: this.user,
            backup: this.user
        }
    },
    methods: {
        onSubmit(event) {
            event.preventDefault()
            this.$http
                .put('/patient/' + this.$store.getters.getUserId)
                .then( res => {
                    if(res.status == 200){
                        console.log('OK')
                    }
                })
        },
        onCancel(event) {
            event.preventDefault()
            this.form = this.backup
        },
        mounted(){
            this.form = JSON.parse(JSON.stringify(this.user))
        }
    },
    components:{
        ChangePasswordModal
    }
}
</script>

<style scoped>
    .penalty-points{
       text-align: middle;
    }

    .penalty-points > span{
        display: block;
    }
</style>