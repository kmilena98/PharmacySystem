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
		userRole: 'ROLE_UNREGISTERED',
		userId : 0,
	},
	mutations: {
		setUserRole(state,newRole) {
			state.userRole = newRole;
		},
		setUserId(state,newUserId) {
			state.userId = newUserId;
		}
	},
	actions: {},
	modules: {},
	getters:{
		getUserRole: state => state.userRole,
		getUserId: state => state.userId
	} ,
});
