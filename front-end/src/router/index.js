import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../components/home/home.component.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
    exact: true
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/login/login.component.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () =>
      import(/* webpackChunkName: "about" */ '../components/about/about.component.vue')
  },
  {
    path: '/contact-us',
    name: 'contactUs',
    component: () => import('../components/contact-us/contact-us.component.vue')
  },
  {
    path: '/pageNotFound',
    name: 'PageNotFound',
    component: () => import('../components/shared/PageNotFound.vue')
  },
  {
    path: '*',
    redirect: {
      name: 'PageNotFound'
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
