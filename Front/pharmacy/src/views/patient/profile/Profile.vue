<template>
    <div class="container">
        <h4 class="h4 align-middle my-4">Profil korisnika</h4>
        <div class="profile-main">
            <b-card no-body>
                <b-tabs pills card align="center" lazy>
                    <b-tab title="Lične informacije" active>
                        <ProfileInformation v-bind:user="user" />
                    </b-tab>
                    <b-tab title="Alergije">
                        <Allergies v-bind:allergies="user.drugAllergies" />
                    </b-tab>
                    <b-tab title="Loyalty program i poeni">
                        <Loyalty v-bind="user" />
                    </b-tab>
                </b-tabs>
            </b-card>
        </div>
    </div>
</template>

<script>
import ProfileInformation from "./ProfileInformation.vue";
import Allergies from "./Allergies.vue";
import Loyalty from "./Loyalty.vue";

export default {
    data(){
        return{
            user: {}
        }
    },
    mounted(){

        this.$http
            .get('/patient/' + this.$store.getters.getUserId)
            .then( res => {
                this.user = res.data
                console.log(this.user)
            })
    },
    components: {
        ProfileInformation,
        Allergies,
        Loyalty
    }
}
</script>
