<template>
  <div id="app" class="d-flex flex-column">
    <Message
      v-if="message !== ''"
      v-bind:message="message"
      v-on:close="message = ''"
    >
    </Message>
    <Header> </Header>
    <router-view v-on:message="message = $event"/>
    <Footer v-on:message="message = $event"> </Footer>
  </div>
</template>

<script>
import Header from './components/shared/Header/Header.component.vue'
import Footer from './components/shared/Footer/Footer.component.vue'
import Message from './components/shared/Message/Message.component.vue'
import { mapGetters } from 'vuex'
console.log()

export default {
  name: 'App',
  data () {
    return { message: '' }
  },
  components: { Header, Footer, Message },
  computed: {
    ...mapGetters(['user'])
  },
  mounted () {
  }
}
</script>
<style>
#app {
  height: 100vh;
}
</style>
