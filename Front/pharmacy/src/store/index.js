import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
<<<<<<< HEAD
		userRole: 'ROLE_UNREGISTERED',
		userId: 0,
		JWT: ''
=======
		userRole: 'ROLE_PHARMACIST',
		userId: 9,
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6ImRpbWl0cmlqZUBnbWFpbC5jb20iLCJhdWQiOiJ3ZWIiLCJpYXQiOjE2MTI3MTU5NTEsImV4cCI6MTYxMzAxNTk1MX0.pXApl6T8yt4tnNjbdiLjvz7BXY19C0x77kxHDzRdwRPbjqGVtLKRUSo35RmaIe1de__Ehap11b_H0aKB7yQ8Ew'
>>>>>>> develop

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
