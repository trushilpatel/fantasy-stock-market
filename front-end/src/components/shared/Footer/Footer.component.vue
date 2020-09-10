<template>
  <footer class="container-fluid footer bg-dark text-white pt-4 pb-4 ">
    <div class="text-center border-bottom pb-3">
      <div class="font-font-weight-bolder pb-4 ">
        <div>
          <span class="border-bottom display-4 ">The Newsletter</span>
        </div>

        <div class="pt-2">
          <span class="">Subsribe To Our News letters</span>
        </div>
      </div>

      <!-- Get Subscribers Details -->
      <form v-on:submit.prevent="submit($event)" class="row ">
        <div class="input-group col-sm-7 ml-auto mr-auto">
          <input
            v-model.trim.lazy="subscriber_email"
            v-on:blur="$v.subscriber_email.$touch()"
            type="text"
            name="email"
            class="form-control border-0 rounded-0"
            placeholder="enter your email..."
          />
          <div class="input-group-append">
            <button class=" form-control btn btn-primary border-0 rounded-0">
              Subscribe
            </button>
          </div>
        </div>
        <div
          v-if="$v.subscriber_email.$dirty && $v.subscriber_email.$invalid"
          class="col-sm-7 ml-auto mr-auto lead text-danger small"
        >
          * Please Enter Valid Email address...
        </div>
      </form>
    </div>

    <div class="container d-flex flex-row justify-content-around mt-3">
      <!-- Social Media Connect With US -->
      <div>
        <div class="pb-1 ">
          <span class="d-block border-bottom ">
            Get In Touch
          </span>
        </div>
        <div>
          <a href="https://www.facebook.com" target="_blank">
            <font-awesome-icon
              :icon="['fab', 'facebook-square']"
              style="color: blue;"
            />
            <span class="small">
              Facebook
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.instagram.com" target="_blank">
            <font-awesome-icon
              :icon="['fab', 'instagram-square']"
              style="color: pink;"
            />
            <span class="small">
              Instagram
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.twitter.com" target="_blank">
            <font-awesome-icon
              :icon="['fab', 'twitter-square']"
              style="color: lightblue;"
            />
            <span class="small">
              Twitter
            </span>
          </a>
        </div>
        <div>
          <a href="https://www.reddit.com" target="_blank">
            <font-awesome-icon
              :icon="['fab', 'reddit-square']"
              style="color: red;"
            />
            <span class="small">
              Reddit
            </span>
          </a>
        </div>
      </div>

      <!-- Site Map -->
      <div class="pb-3">
        <div class="pb-1 ">
          <span class="d-block border-bottom ">
            Site Map
          </span>
        </div>
        <div>
          <template v-if="isAuthenticated">
            <router-link to="/user/home" class="d-block">Home</router-link>
            <router-link to="/user/my-watch-list" class="d-block"
              >My Watch List</router-link
            >
            <router-link to="/user/buy-sell" class="d-block"
              >Buy/Sell</router-link
            >
            <router-link to="/user/transactions" class="d-block"
              >Transactions</router-link
            >
            <router-link to="/user/profile" class="d-block"
              >Profile</router-link
            >
          </template>
          <template v-else>
            <router-link to="/" class="d-block">Home</router-link>
            <router-link to="/contact-us" class="d-block"
              >Contact Us</router-link
            >
            <router-link to="/about" class="d-block">About</router-link>
          </template>
        </div>
      </div>
    </div>

    <!-- Copyright -->
    <p class="text-muted align-baseline mt-1 text-center align-text-middle">
      Copyright 2020 @FSM
      <router-link to="/">
        <img
          src="@/assets/FSM.png"
          height="30px"
          width="30px"
          class="ml-2 text-top"
        />
      </router-link>
    </p>
  </footer>
</template>

<script src="./Footer.component.js" />

<style scoped src="./Footer.component.css" />
