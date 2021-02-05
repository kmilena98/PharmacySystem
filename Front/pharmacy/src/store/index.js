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
		JWT: 'eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiJzcHJpbmctc2VjdXJpdHktZXhhbXBsZSIsInN1YiI6ImZpbGlwQGdtYWlsLmNvbSIsImF1ZCI6IndlYiIsImlhdCI6MTYxMjU1OTkxNSwiZXhwIjoxNjEyODU5OTE1fQ.yzhyac8LMknxuNm_wC82I7XkY1FYZCP54pSl5fhSpWDeEolxzuxFI4vDR1PjotwglLMkuUy4m8h2pohxyZFTHg'

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
