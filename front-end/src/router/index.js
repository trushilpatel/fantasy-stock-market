import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '@/store/index'
import { authGuard } from '@/router/AuthGuard.js'

// Routes
import { UserRoutes } from '@/router/UserRoutes.js'
Vue.use(VueRouter)

const routes = [

  ...UserRoutes,
  {
    path: '/',
    name: 'Home',
    component: () => import('@/components/common/home/home.component.vue'),
    beforeEnter: (to, from, next) => {
      console.log(store)
      next()
    }
  },
  {
    path: '/sign-in',
    name: 'SignIn',
    component: () => import('@/components/authentication/SignIn/SignIn.component.vue')
  },
  {
    path: '/sign-up',
    name: 'SignUp',
    component: () => import('@/components/authentication/SignUp/SignUp.component.vue')
  },
  {
    path: '/about',
    name: 'About',
    component: () =>
      import('@/components/common/about/about.component.vue')
  },
  {
    path: '/contact-us',
    name: 'contactUs',
    component: () => import('@/components/common/contact-us/contact-us.component.vue')
  },
  {
    path: '/pageNotFound',
    name: 'PageNotFound',
    component: () => import('@/components/shared/PageNotFound/PageNotFound.vue')
  },
  {
    path: '*',
    redirect: {
      name: 'PageNotFound'
    }
  }
]
console.log(routes)
const router = new VueRouter({
  mode: 'history',
  routes
})

router.beforeEach(authGuard)
export default router
