<template>
  <div id="app" class="d-flex flex-column">
    <Header > </Header>
    <router-view />
    <Footer > </Footer>
  </div>
</template>

<script>
import Header from './components/shared/Header'
import Footer from './components/shared/Footer'

export default {
  name: 'App',
  components: { Header, Footer }
}
</script>
<style>
#app {
  height: 100vh;
}
</style>
