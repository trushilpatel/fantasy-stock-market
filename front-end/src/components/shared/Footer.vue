<template>
  <footer class="container-fluid footer bg-dark text-white pt-4 pb-4 ">

    <div class="text-center border-bottom pb-3">
      <div class="font-font-weight-bolder pb-4 ">
        <div>
          <span class="border-bottom display-4 ">The Newsletter</span>
        </div>

        <div class="pt-2">
          <span class="">Subsribe to our news letter</span>
        </div>
      </div>
      <form class="row ">
        <div class="input-group col-sm-7 ml-auto mr-auto">
          <input type="text" name="email" class='form-control border-0 rounded-0' placeholder="enter your email...">
          <div class="input-group-append">
            <button class=" form-control btn btn-primary border-0 rounded-0" >Subscribe</button>
          </div>
        </div>

      </form>
    </div>

    <div class="container d-flex flex-row justify-content-around mt-3">
      <div>
        <div class="pb-1 ">
          <span class="d-block border-bottom ">
            Get In Touch
          </span>
        </div>
        <div>
          <a href="https://www.facebook.com" target="_blank">
            <font-awesome-icon :icon="['fab', 'facebook-square']" style="color: blue;"/>
            <span class="small">
              Facebook
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.instagram.com" target="_blank">
            <font-awesome-icon :icon="['fab', 'instagram-square']" style="color: pink;"/>
            <span class="small">
              Instagram
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.twitter.com" target="_blank">
            <font-awesome-icon :icon="['fab', 'twitter-square']" style="color: lightblue;"/>
            <span class="small">
              Twitter
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.reddit.com" target="_blank">
            <font-awesome-icon :icon="['fab', 'reddit-square']" style="color: red;"/>
            <span class="small">
              Reddit
            </span>
          </a>
        </div>
      </div>
      <div class="pb-3">
        <div class="pb-1 ">
          <span class="d-block border-bottom ">
            Site Map
          </span>
        </div>
        <div>
          <router-link to="/" class="d-block">Home</router-link>
          <router-link to="/Contact-us" class="d-block">Contact Us</router-link>
          <router-link to="/about" class="d-block">About</router-link>
        </div>
      </div>
    </div>
      <p class="text-muted align-baseline mt-1 text-center align-text-middle">
        Copyright 2020 @FSM
        <router-link to="/">
          <img src="../../assets/FSM.png" height="30px" width="30px" class="ml-2 text-top">
        </router-link>
      </p>
  </footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
footer {
  margin-top: auto;
}
</style>
