<template>
    <nav class="navbar navbar-expand-sm navbar-light bg-light">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">ISA Projekat</a>
            </div>        
            <SupplierHeader v-if="userRole == 'ROLE_SUPPLIER'" />
            <PatientHeader v-else-if="userRole == 'ROLE_PATIENT'" />
        </div>
    </nav>
</template>

<script>
import PatientHeader from "@/views/header/PatientHeader.vue";
import SupplierHeader from "@/views/header/SupplierHeader.vue";

export default {
    data: function() {
        return{
            userRole: 'ROLE_UNREGISTERED'
        }
    },
	components: {
        PatientHeader,
        SupplierHeader
    },
    mounted(){
        this.userRole = this.$store.getters.getUserRole;
    }
};
</script>