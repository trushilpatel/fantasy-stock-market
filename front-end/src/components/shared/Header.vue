<template>
  <div class="container-fluid">
    <div class="navbar navbar-expand-md bg-dark navbar-dark sticky-top">
      <!-- Brand Name -->
      <router-link to="/" class="navbar-brand">
        <img src="../../assets/FSM.png" height="25px" width="25px" class="mr-2">
        FSM
      </router-link>

      <!-- Toggler Button -->
      <div class="navbar">
        <!-- Login When Toggler is Open -->
        <ul class="navbar-nav mr-3 d-block d-md-none">
          <li class="nav-item ">
            <router-link
              to="/login"
              class="nav-link  bg-primary px-2 py-1 rounded text-white"
              >Log In</router-link
            >
          </li>
        </ul>
        <button
          class="navbar-toggler ml-auto ml-0"
          type="button"
          data-target="#navbar"
          data-toggle="collapse"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
      </div>

      <!-- Navigation Links -->
      <div id="navbar" class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link to="/" exact class="nav-link">Home</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/contact-us" class="nav-link">Contact Us</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/about" class="nav-link">About</router-link>
          </li>
        </ul>
      </div>

      <!-- Login When Toggler is closed -->
      <div class="navbar ml-0 mr-0 d-md-inline-block d-none">
        <ul class="navbar-nav ">
          <li class="nav-item ">
            <router-link
              to="/login"
              class="nav-link d-block bg-primary px-2 py-1 text-white border-0 rounded-0"
              >Log In</router-link
            >
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
  .container-fluid {
    padding: 0px;
  }
</style>
