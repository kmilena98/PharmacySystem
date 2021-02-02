import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

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
