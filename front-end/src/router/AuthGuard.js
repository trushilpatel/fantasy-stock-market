import store from '@/store/index'

function authGuard (to, from, next) {
  if (to.meta.requiresAuth) {
    console.log('RequiredAuth ' + to.meta.requiresAuth)
    if (store.state.User.user.token !== '') {
      next()
    } else {
      next({
        name: 'SignIn'
      })
    }
  } else next()
}

export { authGuard }
