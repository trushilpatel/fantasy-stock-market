import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vuelidate from 'vuelidate'

// Font Awesome Import
import { library } from '@fortawesome/fontawesome-svg-core'
import { faFacebookSquare, faTwitterSquare, faInstagramSquare, faRedditSquare, faGithubSquare } from '@fortawesome/free-brands-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

// Font Awesome Required Font
library.add(faFacebookSquare, faTwitterSquare, faInstagramSquare, faRedditSquare, faGithubSquare)
Vue.component('font-awesome-icon', FontAwesomeIcon)

// Vuelidate for validation
Vue.use(Vuelidate)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
