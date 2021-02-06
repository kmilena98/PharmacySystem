<template>
    <div class="container">
        <b-card no-body class="mt-3">
                <b-tabs pills card align="center" lazy>
                    <b-tab title="Pregledi kod dermatologa" active>
                        <MyDermatologistExaminations />
                    </b-tab>
                    <b-tab title="Pregledi kod farmaceuta">
                        <MyPharmacistExaminations />
                    </b-tab>
                </b-tabs>
        </b-card>
    </div>
</template>

<script>
import MyDermatologistExaminations from './MyDermatologistExaminations.vue'
export default {
    components:{
        MyDermatologistExaminations
    }
}
</script>