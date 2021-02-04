<template>
    <div class="loginClass" >
        <b-row>
            <b-col cols="4">
                <b-form @submit="login" @reset="onReset" v-if="show">
                    <b-form-group id="email-group" label="Email:" label-for="email-input" class="text-center">
                        <b-form-input
                            id="email-input"
                            class="text-center"
                            v-model="form.email"
                            placeholder="Unesite email"
                            required>
                        </b-form-input>
                    </b-form-group>

                    <b-form-group id="password-group" label="Lozinka:" label-for="password-input" class="text-center">
                        <b-form-input
                            type="password"
                            class="text-center"
                            id="password-input"
                            v-model="form.password"
                            placeholder="Unesite lozinku"
                            required>
                        </b-form-input>
                    </b-form-group>          
                    <div class="buttons text-center">                        
                        <b-button type="submit" variant="success" class="mr-2">
                            <b-icon-check></b-icon-check>
                            Uloguj se
                        </b-button>
                        <b-button type="reset" variant="danger">
                            <b-icon-x></b-icon-x>
                            Otkaži
                        </b-button>
                    </div>
                           
                </b-form>
             </b-col>
        </b-row>
    </div>
</template>

<script>


export default {
    data() {
        return {
            form: {
                email: '',
                password: ''
            },
            show: true
        }
    },


    methods: {
        /*
        login(event) {
           event.preventDefault()
           this.$axios.post("http://localhost:9001/auth/login",{
               email : this.form.email,
               password : this.form.password
           })
            .then(response =>  this.$store.getters.getUserRole = response.data.getUserRole)
            .then(response =>  this.$store.getters.getUserId = response.data.getUserId)
            .catch(() => {
            this.$notify({
                type: "error",
                title: 'Error',
                text: 'Doslo je do greske prilikom poziva!',            
                closeOnClick : true
            });
            }
        }, */
        onReset(event) {
            event.preventDefault()
            // Reset our form values
            this.form.email = ''
            this.form.password = ''   
            // Trick to reset/clear native browser form validation state
            this.show = false
            this.$nextTick(() => {
                this.show = true
            })
        }
    },
    components:{
      
    }
}
</script>

