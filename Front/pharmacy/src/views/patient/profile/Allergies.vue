<template>
    <div class="allergies">
        <h5 class="h5 text-left">Spisak vaših alegija</h5>
        <ul class="text-left">
            <li>
                Prva alergija
                <b-button  @click="deleteAllergy(0)" size="sm" variant="danger" class="button ml-2">
                    <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                </b-button>
            </li>
            <li>
                Prva alergija
                <b-button  @click="deleteAllergy(1)" size="sm" variant="danger" class="button ml-2">
                    <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                </b-button>
            </li>
            <li>
                Prva alergija
                <b-button  @click="deleteAllergy(index)" size="sm" variant="danger" class="button ml-2">
                    <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                </b-button>
            </li>
            <li>
                Prva alergija
                <b-button  @click="deleteAllergy(index)" size="sm" variant="danger" class="button ml-2">
                    <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                </b-button>
            </li>
        </ul>
        <!--<b-row>
            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(0)" :key="index">
                        {{allergy}}
                        <b-button  @click="deleteAllergy(index)" size="sm" variant="danger" class="button ml-2">
                            <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>

            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(1)" :key="index">
                        {{allergy}}
                        <b-button  @click="deleteAllergy(index)" size="sm" variant="danger" class="button ml-2">
                            <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>

            <b-col>
                <ul class="text-left">
                    <li v-for="(allergy, index) in splicedAllergies(2)" :key="index">
                        {{allergy}}
                        <b-button @click="deleteAllergy(index)" size="sm" variant="danger" class="button ml-2" 
                                  v-b-tooltip.hover title="Obriši alergiju">
                            <b-icon-trash-fill width="16" height="16" variant="default"></b-icon-trash-fill>
                        </b-button>
                    </li>
                </ul>
            </b-col>
        </b-row>-->

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
            return allergies.splice(Math.ceil(allergies.length / 3) * index, Math.ceil(allergies.length / 3) * index + Math.ceil(allergies.length / 3) )
        },
        deleteAllergy: function(index){
            console.log(index)
            this.allergies.slice(index, 1)
            console.log(this.allergies)
        }
    },
    components:{
        AddAllergyModal
    }
}
</script>

<style scoped>
    .button{
        height: 1.5rem;
        width: 1.5rem;
    }
</style>