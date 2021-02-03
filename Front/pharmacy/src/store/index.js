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
		userRole: 'ROLE_PATIENT',
		userId: 1,
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6ImZpbGlwQGdtYWlsLmNvbSIsImF1ZCI6IndlYiIsImlhdCI6MTYxMjM3NjU4MSwiZXhwIjoxNjEyNjc2NTgxfQ.sjduFC3N8pekJOK3cgcaTWLkf1fwmuoKOHzG8awCIC0qoZOZxvplohpAhx6K7Z0QrrPJEDaxycCftM4y78fS9A'
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
