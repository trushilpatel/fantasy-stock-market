<template>
  <div class="container-fluid">
    <div class="navbar navbar-expand-md bg-dark navbar-dark sticky-top ">
      <!-- Brand Name -->
      <router-link to="/" class="navbar-brand border-0">
        <img src="@/assets/FSM.png" height="25px" width="25px" class="mr-2" />
        FSM
      </router-link>
      <!-- Toggler Button -->
      <div class="navbar">
        <!-- Sign In/Sign Up When Toggler is Open -->
        <ul class="navbar-nav mr-3 d-block d-md-none">
          <li class="nav-item">
            <router-link
              v-if="!isAuthenticated"
              to="/sign-up"
              class="nav-link border-0   bg-primary px-2 py-1 text-white"
              >Sign Up</router-link
            >
          </li>
        </ul>
        <ul class="navbar-nav mr-3 d-block d-md-none">
          <li class="nav-item ">
            <router-link
              v-if="!isAuthenticated"
              to="/sign-in"
              class="nav-link border-0  bg-primary px-2 py-1  text-white"
              >Sign In</router-link
            >
          </li>
        </ul>
        <ul class="navbar-nav mr-3 d-block d-md-none">
          <li class="nav-item ">
            <button
              v-if="isAuthenticated"
              v-on:click="signOut()"
              class="nav-link border-0  bg-primary px-2 py-1  text-white"
            >
              Sign Out
            </button>
          </li>
        </ul>
        <button
          class="navbar-toggler ml-auto ml-0 rounded-0"
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
          <!-- Header Links Only For Signed In users -->
          <template v-if="isAuthenticated">
            <li class="nav-item">
              <router-link to="/user/home" exact class="nav-link"
                >Home</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/user/my-watch-list" exact class="nav-link"
                >My Watch List</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/user/buy-sell" exact class="nav-link"
                >Buy/Sell</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/user/transactions" exact class="nav-link"
                >Transactions</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/user/profile" exact class="nav-link"
                >Profile</router-link
              >
            </li>
          </template>

          <!-- General Header Links -->
          <template v-else>
            <li class="nav-item">
              <router-link to="/" exact class="nav-link">Home</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/contact-us" class="nav-link"
                >Contact Us</router-link
              >
            </li>
            <li class="nav-item">
              <router-link to="/about" class="nav-link">About</router-link>
            </li>
          </template>
        </ul>
      </div>

      <!-- Login When Toggler is closed -->
      <div class="navbar ml-0 mr-0 d-md-inline-block d-none">
        <ul class="navbar-nav d-block">
          <li class="nav-item ">
            <router-link
              v-if="!isAuthenticated"
              to="/sign-up"
              class="nav-link d-block bg-primary px-2 py-1 text-white border-0 rounded-0"
              >Sign Up</router-link
            >
          </li>
        </ul>
      </div>
      <div class="navbar ml-0 mr-0 d-md-inline-block d-none">
        <ul class="navbar-nav d-block">
          <li class="nav-item ">
            <router-link
              v-if="!isAuthenticated"
              to="/sign-in"
              class="nav-link d-block bg-primary px-2 py-1 text-white border-0 rounded-0"
              >Sign In</router-link
            >
          </li>
        </ul>
      </div>
      <div class="navbar ml-0 mr-0 d-md-inline-block d-none">
        <ul class="navbar-nav d-block">
          <li class="nav-item ">
            <button
              v-if="isAuthenticated"
              v-on:click="signOut()"
              class="nav-link d-block bg-primary px-2 py-1 text-white border-0 rounded-0"
            >
              Sign Out
            </button>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script src="./Header.component.js" />

<style scoped src="./Header.component.css" />
