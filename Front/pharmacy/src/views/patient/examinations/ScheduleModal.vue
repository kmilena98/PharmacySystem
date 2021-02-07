<template>
    <div>
        <b-button v-b-modal="'my-modal'" variant="success">
            <b-icon-calendar-check shift-h="-3"></b-icon-calendar-check>
            Zakaži konsultovanje
        </b-button>

        <b-modal id="my-modal" hide-footer title="Zakazivanje savetovanja kod farmaceuta" @hidden="closeModal">
            <div v-if="showPharmacy" class="pharmacy-selection">
                <b-form>
                    <b-form-group id="from-date-group" label="Datum od:" label-for="from-date-input">
                        <b-form-datepicker id="from-date-input" v-model="fromDate" placeholder="Izaberite datum" class="mb-2"></b-form-datepicker>
                        <b-form-timepicker v-model="fromTime" placeholder="Izaberite vreme" locale="en"></b-form-timepicker>
                    </b-form-group>

                    <b-form-group id="to-date-group" label="Datum do:" label-for="to-date-input">
                        <b-form-datepicker id="to-date-input" v-model="toDate" placeholder="Izaberite datum" class="mb-2"></b-form-datepicker>
                        <b-form-timepicker v-model="toTime" placeholder="Izaberite vreme" locale="en"></b-form-timepicker>
                    </b-form-group>

                    <b-button @click="findPharmacies()" block variant="success">
                        Pretraži
                    </b-button>
                </b-form>

                <b-table striped hover :items="pharmacyItems" :fields="pharmacyFields" class="mt-3">
                    <template #cell(akcije)="">
                        <b-button @click="showPharmacistsDialog()" size="sm" >
                            Pogledaj
                        </b-button>
                    </template>
                </b-table>            
            </div>       

            <div v-if="showPharmacist" class="pharmacist-selection">
                <div class="pharmacist-title">
                    <b-button @click="closeModal" class="p-0" size="sm" variant="bg-transparent default">
                        <b-icon-chevron-left font-scale="1.5"></b-icon-chevron-left>
                    </b-button>
                    <h6 class="h6 mt-1 ml-2">Slobodni farmaceuti</h6>
                </div>                
                <b-table striped hover :items="pharmacistItems" :fields="pharmacistFields" class="mt-3">
                    <template #cell(akcije)="">
                        <b-button size="sm" >
                            Zakaži
                        </b-button>
                    </template>
                </b-table>     
            </div>
            

        </b-modal>
    </div>    
</template>

<script>
export default {
    data(){
        return {
            pharmacyItems: [
				{ime: 'Apoteka', grad: 'Novi Sad', ocena: 4.5, cena: '1500 din'},
				{ime: 'Apoteka', grad: 'Novi Sad', ocena: 4.5, cena: '1500 din'},
				{ime: 'Apoteka', grad: 'Novi Sad', ocena: 4.5, cena: '1500 din'},
				{ime: 'Apoteka', grad: 'Novi Sad', ocena: 4.5, cena: '1500 din'},
				{ime: 'Apoteka', grad: 'Novi Sad', ocena: 4.5, cena: '1500 din'}
			],
			pharmacyFields:['ime', 'grad', {key: 'ocena', sortable: true}, {key: 'cena', sortable: true}, 'akcije'],

            pharmacistItems: [
				{ime: 'Apoteka', prezime: 'Novi Sad', ocena: 4.5},
				{ime: 'Apoteka', prezime: 'Novi Sad', ocena: 4.5},
				{ime: 'Apoteka', prezime: 'Novi Sad', ocena: 4.5},
				{ime: 'Apoteka', prezime: 'Novi Sad', ocena: 4.5},
				{ime: 'Apoteka', prezime: 'Novi Sad', ocena: 4.5},
			],
			pharmacistFields:['ime', 'prezime', {key: 'ocena', sortable: true}, 'akcije'],

            showPharmacy: true,
            showPharmacist: false,

            fromDate: '',
            fromTime: '10:00',
            toDate: '',
            toTime: '12:00',
        }
    },
    methods:{
        showPharmacistsDialog(){
            this.showPharmacy = false
            this.showPharmacist = true
        },
        closeModal(){
            this.showPharmacy = true
            this.showPharmacist = false
        },
        findPharmacies(){            
            if(this.fromDate == '' || this.toDate == '' || this.fromTime == '' || this.toTime == ''){
                this.toast('Niste popunili sve datume! Molimo Vas popunite sva polja.', 'Neuspešno', 'danger')
                return;
            }

            if(new Date(this.fromDate + ' ' + this.fromTime).getTime() > new Date(this.toDate + ' ' + this.toTime).getTime()){
                this.toast('"Datum do" ne može biti manji od "Datum od".', 'Neuspešno', 'danger')
                return;
            }

            this.$http
                .post('examination/search', {
                    from: new Date(this.fromDate + ' ' + this.fromTime).getTime(),
                    to: new Date(this.toDate + ' ' + this.toTime).getTime(),
                    type: 'PharmacistExamination'
                })
                .then( res => {
                    if(res.status == 200){  
                        console.log(res.data)
                    }            
                })
        },
        toast(message, title, variant){
            this.$bvToast.toast(message, {
                title: title,
                variant: variant,
                autoHideDelay: 5000
            })
        }
    },
}
</script>

<style scoped>

    .pharmacist-title{
        display: flex;
    }

</style>