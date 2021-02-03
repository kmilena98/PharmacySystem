import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
	state: {
		userRole: 'ROLE_PATIENT',
		userId: 1,
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6InBlcmEiLCJhdWQiOiJ3ZWIiLCJpYXQiOjE2MTIzNTI3MDQsImV4cCI6MTYxMjY1MjcwNH0.W4GDUScylWpVHBGBvd_1oID9lD_iEwPo04Mw9sg6u2B7otFR5B_0F0-UfHqcd4sstTTET7OugWfhw8GjuxAE4A'
	},
	mutations: {},
	actions: {},
	modules: {},
	getters:{
		getUserRole: state => state.userRole,
		getUserId: state => state.userId,
		getJWT: state => state.JWT
	}
});
