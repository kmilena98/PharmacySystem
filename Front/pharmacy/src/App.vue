<template>
	<div id="app">
			<Header />
		<router-link to="/">Home</router-link> |
		<router-link to="/about">About</router-link>
			<router-link to="/patients">Patients</router-link>
		<router-view />
	</div>
</template>

<script>
import Header from "@/views/header/Header.vue";

export default {
	name: "App",
	components: {
		Header
	}
};
</script>

<style>
#app {
	font-family: 'Segoe UI', Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
}
</style>
