<template>
  <div id="sign-in" class="container-fluid pb-5">
    <div class=" pt-5">
      <form
        v-on:submit.prevent="submit()"
        class="col-md-5 px-0 ml-auto mr-auto   shadow "
      >
        <div class=" text-center font-weight-bolder bg-dark py-3 text-white">
          <div class="lead display-4 ">
            <img
              src="@/assets/FSM.png"
              height="70rem"
              width="70rem"
              class="mr-3"
            />
            FSM
          </div>
        </div>

        <div class="my-4 mb-5 mx-5">
          <div class="form-group mt-5 pt-1 shadow-lg">
            <div class="input-group  my-5 px-3 ">
              <span
                class="input-group-text bg-dark text-white border-dark border-0 rounded-0"
              >
                E-mail
              </span>
              <input
                v-model="email"
                v-on:blur="$v.email.$touch()"
                autocomplete="email"
                type="email"
                name="email"
                class="form-control  text-white border-dark bg-gray border-0 rounded-0"
              />
            </div>
            <div
              v-if="$v.email.$dirty && $v.email.$invalid"
              class=" ml-auto mr-auto lead text-danger small"
            >
              * Please enter valid email address...
            </div>
            <div class="input-group my-5 px-3 ">
              <span
                class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0"
              >
                Password
              </span>
              <input
                v-model="password"
                v-on:blur="$v.password.$touch()"
                autocomplete="password"
                type="password"
                name="password"
                class="form-control text-white border-dark bg-gray border-0 rounded-0"
              />
            </div>
            <div
              v-if="$v.password.$dirty && $v.password.$invalid"
              class="ml-auto mr-auto lead text-danger small"
            >
              * Password must be 8 character long (should contain small
              alphabet, capital alphabet,one number)
            </div>

            <div class="mt-4 bg-dark">
              <button
                type="submit"
                class="py-3  btn btn-block btn-primary ml-auto mr-auto px-0 border-0 rounded-0"
              >
                Sign In
              </button>
            </div>
          </div>
        </div>

        <div class=" ">
          <button
            type="submit"
            class="py-3 btn btn-block btn-success border-0 rounded-0"
            v-on:click="$router.push('/sign-up')"
          >
            Sign Up to FSM
          </button>

        </div>
      </form>
    </div>
  </div>
</template>

<script src="./SignIn.component.js"></script>

<style src="./SignIn.component.css" scoped></style>
