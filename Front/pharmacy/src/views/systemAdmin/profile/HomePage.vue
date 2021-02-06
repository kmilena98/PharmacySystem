<template>
    <div class="container">
        <h4 class="h4 align-middle my-4">Korisnici</h4>
        <div class="users-main">
            <b-card no-body >
                <b-tabs pills card align="center" lazy>
                    <b-tab title="Administratori sistema" active class="text-center">
                        <Login />
                    </b-tab>
                     <b-tab title="Administratori apoteke" active class="text-center">
                        <Login />
                    </b-tab>
                    <b-tab title="Dermatolozi" active class="text-center">
                        <Login />
                    </b-tab>
                      <b-tab title="Dobavljaci" active class="text-center">
                        <Login />
                    </b-tab>
                </b-tabs>
            </b-card>
        </div>
    </div>
</template>

<script>
import Login from "../../registration/Login.vue";


export default {
    components: {
        Login
    }
}
</script>