const UserRoutes = [
  {
    path: '/user',
    name: 'User',
    meta: { requiresAuth: true },
    component: () => import('@/components/user/User.vue'),

    children: [
      {
        path: 'home',
        name: 'UserHome',
        meta: { requiresAuth: true },
        component: () => import('@/components/user/UserHome/UserHome.component.vue')

      },
      {
        path: 'my-watch-list',
        name: 'UserMyWatchList',
        meta: { requiresAuth: true },
        component: () => import('@/components/user/MyWatchList/MyWatchList.component.vue')
      },
      {
        path: 'profile',
        name: 'UserProfile',
        meta: { requiresAuth: true },
        component: () => import('@/components/user/Profile/Profile.component.vue')
      },
      {
        path: 'buy-sell',
        name: 'UserBuySell',
        meta: { requiresAuth: true },
        component: () => import('@/components/user/BuySell/BuySell.component.vue')
      },
      {
        path: 'transactions',
        name: 'UserTransactions',
        meta: { requiresAuth: true },
        component: () => import('@/components/user/Transactions/Transactions.component.vue')
      }
    ]
  }
]

export { UserRoutes }
