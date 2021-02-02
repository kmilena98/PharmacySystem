import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);
Vue.prototype.$axios = axios


export default new Vuex.Store({
	state: {
		userRole: 'ROLE_PATIENT'
	},
	mutations: {},
	actions: {},
	modules: {},
	getters:{
		getUserRole: state => state.userRole
	}
});
