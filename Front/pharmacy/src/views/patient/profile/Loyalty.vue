<template>
    <div class="loyalty">
        <b-row>
            <b-col class="text-left">
                <h6 class="h6">Loyalty program</h6>
                <b-row>
                    <b-col class="loyalty-category">
                        <b-icon-award-fill width="32" height="32"></b-icon-award-fill>
                        <h3 class="h3">GOLD</h3>
                    </b-col>
                    <b-col>
                        <b-row>
                            <b-col class="loyalty-points">
                                <h5 class="h5">102</h5>
                                <span>POENA</span>
                            </b-col>

                            <b-col>

                            </b-col>

                        </b-row>                        
                    </b-col>
                </b-row>
            </b-col>
            <b-col class="text-left">
                <h6 class="h6">Kazneni penali</h6>
                <div class="penalty-points">
                    <span>0</span>
                    <span>KAZNENIH POENA</span>
                </div>
            </b-col>
        </b-row>
    </div>
</template>

<style scoped>

    .loyalty-category{
        display: flex;
        align-content: center;
    }

    .loyalty-points{
        border: 2px solid black;
        border-radius: 50%;
        width: 50px;
        height: 50px;
    }

    .penalty-points > *{
        display: block;
    }
</style>