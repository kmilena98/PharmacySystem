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
		userId: 5,
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6ImZpbGlwQGdtYWlsLmNvbSIsImF1ZCI6IndlYiIsImlhdCI6MTYxMjM4MjY0NywiZXhwIjoxNjEyNjgyNjQ3fQ.MpfhEZ8BkWF4ykOm4K8ess3tIS-p76EdOJ71h0kkR9CDGebj2Jvru8iAqHFmD1DRZGu9yJ75QiwSPLfcI1rR9A'
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
