import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import Notifications from 'vue-notification';
import velocity      from 'velocity-animate'

Vue.use(Vuex);
Vue.use(Notifications, { velocity })
Vue.prototype.$axios = axios


export default new Vuex.Store({
	state: {
		userRole: 'ROLE_PHARMACY_ADMIN',
		userId: 13,
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6Im1pbGVuYUBnbWFpbC5jb20iLCJhdWQiOiJ3ZWIiLCJpYXQiOjE2MTI3NDYxNzksImV4cCI6MTYxMzA0NjE3OX0.-esdmJ6l4IzPIqURvbEGbc9RPRPjHB_OrPn2aViN7xU6PqaZawj-N1-58vugoLnN-7Ao4wIrzDQX4-4z3ZrJtA'

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
