<template>
  <div class="container-fluid pb-5">
    <div class="col-12 text-center display-4 border-bottom">Profile</div>

    <div class="col-md-8  ml-auto mr-auto">
      <div class="mr-auto ml-auto">
        <form v-on:submit.prevent="submit()" class="mt-auto mb-auto">
          <div class="my-4 mb-5">
            <div class="form-group mt-5 border p-3 border-dark shadow-lg">
              <div class="input-group my-3 col-10 ml-auto mr-auto">
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
                  class="form-control  text-dark bg-gray rounded-0"
                />
              </div>
              <div
                v-if="$v.email.$dirty && $v.email.$invalid"
                class="col-10 ml-auto mr-auto ml-auto mr-auto lead text-danger small"
              >
                * Please enter valid email address...
              </div>
              <div class="col-10 border p-4 ml-auto mr-auto my-4">
                <div class="font-weight-bold">Update Password</div>
                <div class="input-group my-4">
                  <span
                    class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0"
                  >
                    Old Password
                  </span>
                  <input
                    v-model="oldPassword"
                    v-on:blur="$v.oldPassword.$touch()"
                    autocomplete="password"
                    type="password"
                    name="password"
                    class="form-control text-dark  bg-gray rounded-0"
                  />
                </div>
                <div
                  v-if="$v.oldPassword.$dirty && $v.oldPassword.$invalid"
                  class="ml-auto mr-auto lead text-danger small"
                >
                  * Password must be 8 character long (should contain small
                  alphabet, capital alphabet,one number)
                </div>

                <div class="input-group my-4">
                  <span
                    class="input-group-text bg-dark text-white border-dark border-right-0 border-0 rounded-0"
                  >
                    New Password
                  </span>
                  <input
                    v-model="newPassword"
                    v-on:blur="$v.newPassword.$touch()"
                    autocomplete="password"
                    type="password"
                    name="password"
                    class="form-control text-dark  bg-gray rounded-0"
                  />
                </div>
                <div
                  v-if="$v.newPassword.$dirty && $v.newPassword.$invalid"
                  class="ml-auto mr-auto lead text-danger small"
                >
                  * Password must be 8 character long (should contain small
                  alphabet, capital alphabet,one number)
                </div>
              </div>

              <div class="mt-4 mb-4">
                <button
                  type="submit"
                  class=" col-10 form-control btn btn-block btn-primary ml-auto mr-auto px-0 border-0 rounded-0"
                >
                  Save
                </button>
              </div>
              <div class="mt-4 mb-4">
                <button
                  type="submit"
                  class=" col-10 form-control btn btn-block btn-primary ml-auto mr-auto px-0 border-0 rounded-0"
                >
                  Save
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script src="./Profile.component.js" />
<style src="./Profile.component.css" />
