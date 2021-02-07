import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		userRole: localStorage.getItem("UserRole"),
		userId: localStorage.getItem("UserId"),
		JWT: localStorage.getItem("JWT")
	},
	mutations: {
		setUserRole(state,newRole) {
			state.userRole = newRole;
		},
		setUserId(state,newUserId) {
			state.userId = newUserId;
		},
		setJWT(state,newJWT) {
			state.JWT = newJWT;
		}
	},
	actions: {},
	modules: {},
	getters:{
		getUserRole: state => state.userRole,
		getUserId: state => state.userId,
		getJWT: state => state.JWT
	}
});
