<template>    
    <ul class="nav navbar-nav">
        <li class="nav-item active"><a href="#" class="nav-link">Moj radni kalendar</a></li>
        <li class="nav-item"><a href="#" class="nav-link">Moji pacijenti</a></li>
        <li class="nav-item"><a href="#" class="nav-link">Godisnji odmor i odsustva</a></li>
        <li class="nav-item"><a href="#" class="nav-link">Preporuci lekove</a></li>
        <li class="nav-item"><a href="#" class="nav-link">Zakazi savetovanje</a></li>
        <b-nav-item-dropdown text="Mirko Mirković" right>
          <b-dropdown-item href="#"><router-link to="/patient-profile">Moj profil</router-link></b-dropdown-item>
          <b-dropdown-item href="#" @click="logout" >Odjava</b-dropdown-item>
        </b-nav-item-dropdown>
    </ul>   
</template>
