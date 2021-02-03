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
		userRole: 'ROLE_PATIENT'
	},
	mutations: {},
	actions: {},
	modules: {},
	getters:{
		getUserRole: state => state.userRole
	}
});
