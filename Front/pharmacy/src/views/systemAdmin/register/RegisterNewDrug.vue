
<template>
    <div class="register">
        <b-form id = "form" v-if="show">
            <b-row>
                <b-col>
                <b-form-group id="name-group" label="Naziv:" label-for="name-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="name-input"
                        v-model="drug.name"
                        placeholder="Unesite naziv leka"
                        required>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="code-group" label="Sifra:" label-for="code-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="code-input"
                        v-model="drug.code"
                        placeholder="Unesite sifru leka"
                        required>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="type-group" label="Tip leka:" label-for="typa-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="type-input"
                        v-model="drug.type"
                        placeholder="Unesite tip leka"
                        required>
                    </b-form-input>
                </b-form-group>

                <b-form-group id="shape-group" label="Oblik:" label-for="shape-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="shape-input"
                        v-model="drug.shape"
                        placeholder="Unesite oblik leka"
                        required>
                    </b-form-input>
                </b-form-group>
            </b-col>
            <b-col>
            <b-form-group id="manifacturer-group" label="Proizvodjac:" label-for="manifacturer-input" class="text-center">
                <b-form-input
                    class="text-center"
                    id="manifacturer-input"
                    v-model="drug.manifacturer"
                    placeholder="Unesite proizvodjaca"
                    required>
                </b-form-input>
            </b-form-group>

            <b-form-group id="suggestedDose-group" label="Preporucena doza:" label-for="suggestedDose-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="suggestedDose-input"
                        v-model="drug.suggestedDose"
                        placeholder="Unesite preporucenu dozu"
                        required>
                    </b-form-input>
                </b-form-group>

             <b-form-group id="loyaltyPoints-group" label="Lojalni poeni:" label-for="loyaltyPoints-input" class="text-center">
                <b-form-input

                    class="text-center"
                    type = "number"
                    min = "0"
                    id="loyaltyPoints-input"
                    v-model="drug.loyaltyPoints"
                    placeholder="Unesite broj lojalti poena"
                    required>
                </b-form-input>
            </b-form-group>

            <b-form-group id="additionalInfo-group" label="Dodatne napomene:" label-for="additionalInfo-input" class="text-center">
                <b-form-textarea
                    rows = "3"
                    class="text-center"
                    id="additionalInfo-input"
                    v-model="drug.additionalInfo"
                    placeholder="Unesite dodatne napomene"
                    required>
                </b-form-textarea>   
            </b-form-group>
                    
         </b-col>
        </b-row>
        <b-row>
            <b-col >
                 <div>
                <b-form-group id="contraindication-group" label="Unesite nezeljeno dejstvo:" label-for="contraindication-input" class="text-center">
                    <b-form-input
                        class="text-center"
                        id="contraindication-input"
                        v-model="drug.contraindication"
                        placeholder="Unesite nezeljeno dejstvo"
                        required>
                    </b-form-input>
                   
                </b-form-group>
                 <b-button type="submit" variant="success" class="mr-2">
                        Dodaj
                    </b-button>
                    </div>
            </b-col>
            <b-col>
                <label>Uneta nezeljena dejsta</label>
                  
                <div id="contraindications-table">
                    <b-table id = "table" striped hover primary-key="id" :tbody-transition-props="transProps" :items="contraindications" ></b-table>
                </div>
            </b-col>
        </b-row>
        </b-form>
        <div class="buttons text-center">                        
                <b-button @click="onSubmit()" variant="success" class="mr-2">
                    <b-icon-check></b-icon-check>
                    Dodaj lek</b-button>
                <b-button @click="onReset()" variant="danger">
                    <b-icon-x></b-icon-x>
                    Otkaži
                </b-button>
            </div>
    </div>
</template>

<script>


export default {
    data() {
        return {
            drug: {
                name: '',
                code: '',
                type: '',
                shape: '',
                manifacturer: '',
                additionalInfo: '',
                loyaltyPoints: '',
                suggestedDose: '' ,
                contraindication: '',
                contraindications: [{id : 1 ,'name' : 'nezeljeno1'},{id : 2, 'name' : 'nezeljeno2'}]           
            },
           
            show: true
        }
    },
    methods: {
          onSubmit(event) {
            event.preventDefault()
            this.passwordError = false;
            if(this.user.passwordCheck !== this.user.password){
                this.passwordError = true;
            }
            if(!this.passwordError){
                this.$http
                .post("auth/signupDermatologist",{
                    email : this.user.email,
                    password : this.user.password,
                    firstName : this.user.name,
                    lastName : this.user.surname,
                    address : this.user.address,
                    city : this.user.city,
                    country : this.user.country,
                    phoneNumber : this.user.phone,
                    price : this.user.price
            })
            .then( () => {
                  this.toast()  
                   
                })                    
                .catch(function (error) {
                    if(error.response.status === 500) {
                    alert('Vec postoji korisnik sa unetim imejlom');               
                    }
                });    
            }     
        },
        toast(){
            this.$bvToast.toast(`Uspešno ste registrovali novog dermatologa!`, {
                title: 'Uspešno!',
                variant: 'success',
                autoHideDelay: 5000
            })
        },
        onReset(event) {
            event.preventDefault()
            // Reset our form values
            this.user.email = ''
            this.user.password = ''
            this.user.passwordCheck = ''
            this.user.name = ''
            this.user.surname = ''
            this.user.address = ''
            this.user.city = ''
            this.user.phone = ''
            this.passwordError = false
            this.user.price = 0
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
<style scoped>
    #form {
        width : 80%;
        margin : auto
    }
   /* #loyaltyPoints-group {
        margin-top: 7%;
    } */
</style>
