<template>
    <div class="patient-information">
        <b-row>
            <b-col cols="8">
                <b-form @submit="onSubmit" @reset="onReset" v-if="show">
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
                            v-model="form. surname"
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
                            v-model="form.phone"
                            placeholder="Unesite broj telefona"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <div class="buttons text-left">                        
                        <b-button type="submit" variant="success" class="mr-2">
                            <b-icon-check></b-icon-check>
                            Izmeni informacije</b-button>
                        <b-button type="reset" variant="danger">
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
    data() {
        return {
            form: {
                email: '',
                name: '',
                food: null,
                checked: []
            },
            foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
            show: true
        }
    },
    methods: {
        onSubmit(event) {
            event.preventDefault()
            alert(JSON.stringify(this.form))
        },
        onReset(event) {
            event.preventDefault()
            // Reset our form values
            this.form.email = ''
            this.form.name = ''
            this.form.food = null
            this.form.checked = []
            // Trick to reset/clear native browser form validation state
            this.show = false
            this.$nextTick(() => {
                this.show = true
            })
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