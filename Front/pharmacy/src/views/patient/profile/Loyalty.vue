<template>
    <div class="loyalty">
        <b-row>
            <b-col class="text-left">
                <h6 class="h6">Loyalty program</h6>
                <b-row>
                    <b-col>
                        <div class="loyalty-category">
                            <b-icon-award-fill width="32" height="32"></b-icon-award-fill>
                            <h3 class="h3">GOLD</h3>
                        </div>                        
                        <span>30% popusta</span>
                    </b-col>
                    <b-col>
                        <div class="loyalty-points">
                            <h5 class="h5">{{loyalty_points}}</h5>
                            <span>POENA</span>
                        </div>                       
                    </b-col>
                </b-row>
            </b-col>
            <b-col class="text-left">
                <h6 class="h6">Kazneni penali</h6>
                <div class="penalty-points">
                    <span>{{penalty_points}}</span>
                    <span>KAZNENIH POENA</span>
                </div>
            </b-col>
        </b-row>
    </div>
</template>

<script>
export default {
    data(){
        return{
            loyalty_points: 0,
            penalty_points: 0
        }
    },
    mounted(){
        this.$http
            .get('/patient/' + this.$store.getters.getUserId)
            .then( res => {
                this.loyalty_points = res.data.loyaltyPoints
                this.penalty_points = res.data.penaltyPoints
            })
    }
}
</script>

<style scoped>

    .loyalty-category{
        display: flex;
        align-content: center;
    }

    /*.loyalty-points{
        border: 2px solid black;
        border-radius: 50%;
        width: 100px;
        height: 100px;
        text-align: center;
        align-self: center;
    }*/

    .penalty-points > *{
        display: block;
    }
</style>