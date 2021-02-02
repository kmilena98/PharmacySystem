<template>
  <div class="allergy-modal">
      <b-button v-b-modal="'allergy'" 
                variant="success"
                size="sm"
                class="float-left">
                <b-icon-plus></b-icon-plus>
                Dodaj alergiju
    </b-button>

    <b-modal id="allergy" hide-footer title="Dodaj alergiju na lek">
        <b-form @submit="onSubmit" @reset="onReset">
            <b-form-select v-model="selected" :options="options"></b-form-select>

            <b-button type="submit" block variant="success">
                Dodaj alergiju
            </b-button>

            <b-button type="submit" block variant="danger">
                Otkaži
            </b-button>

            <!--<b-button class="mt-3" variant="outline-danger" block @click="hideModal">Close Me</b-button>
            <b-button class="mt-2" variant="outline-warning" block @click="toggleModal">Toggle Me</b-button>-->
        </b-form>
    </b-modal>
  </div>
</template>

<script>
export default {
    data(){
        return{
            form:{
                oldPassword:'',
                newPassword: ''
            }
        }
    }
}
</script>