<template>
    <div class="allergies">
        <h5 class="h5 text-left">Spisak vaših alegija</h5>
        <b-row>
            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(0)" :key="index">
                        {{allergy}}
                        <b-button @click="deleteAllergy(index, 0)" size="sm" variant="danger" class="button ml-2">
                            <b-icon-trash-fill variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>

            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(1)" :key="index">
                        {{allergy}}
                        <b-button @click="deleteAllergy(index, 1)" size="sm" variant="danger" class="button ml-2">
                            <b-icon-trash-fill variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>

            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(2)" :key="index">
                        {{allergy}}
                        <b-button @click="deleteAllergy(index, 2)" size="sm" variant="danger" class="button ml-2" 
                                  v-b-tooltip.hover title="Obriši alergiju">
                            <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>
        </b-row>

        <AddAllergyModal />
        
    </div>
</template>

<script>
import AddAllergyModal from './AddAllergyModal.vue';
export default {
    data() {
        return {
            allergies: ['Prva alergija', 'Druga alergija', 'Treca alergija', 'Cetvrta alergija', 'peta']
        }
    },
    methods:{
        splicedAllergies: function(index) {
            let allergies = Array.from(this.allergies)
            return allergies.slice(Math.ceil(allergies.length / 3) * index, Math.ceil(allergies.length / 3) * index + Math.ceil(allergies.length / 3) )
        },
        deleteAllergy: function(index, column){
            index = Math.ceil(this.allergies.length / 3) * column + index;
            this.allergies.splice(index, 1)
        }
    },
    components:{
        AddAllergyModal
    }
}
</script>

<style scoped>

    .button{
        width: 1.4rem;
        height: 1.4rem;
    }

    .button > * {

    }

</style>