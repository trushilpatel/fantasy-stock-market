<template>
  <div id="about" class="container-fluid  pb-5">
    <div class="ml-auto mr-auto">
      <div class="my-5">
        <div
          class="card col-md-6 p-0 border-0 ml-auto mr-auto shadow-lg text-center "
        >
          <div
            class="font-weight-bold py-4 display-4 bg-dark border-dark text-center text-white border-bottom border-white"
          >
            About Us
          </div>
          <img
            src="@/assets/trushilpatel.jpg"
            alt="Trushil Patel"
            class="my-3 card-img-top w-50 h-50 ml-auto  mr-auto mb-0 rounded-circle "
          />
          <div class="card-body text-dark">
            <h4 class="card-title px-3 pb-3 border-bottom">
              <span class="d-inline-block ">Trushil Patel</span>
              <span class="d-block lead small py-3 text-small">
                Developer At <span class="font-weight-bold">FSM</span>
                <img
                  src="@/assets/FSM.png"
                  class="ml-2"
                  height="30px"
                  width="30px"
                />
              </span>
            </h4>

            <p class="card-text text-center text-justify">
              I have created this website during the training at
              <a href="https://www.argusoft.com" class="font-weight-bold"
                >Argusoft</a
              >
            </p>
            <p class="card-text text-center text-justify">
              Under the guidance of
              <span class="text-success font-weight-bold">Shifa Salheen</span>
              ma'am and
              <span class="text-success font-weight-bold">Maulik Desai</span>
              sir
            </p>
          </div>
          <div class=" pt-3  bg-dark border-top border-bottom py-3 px-5">
            <div class="d-flex justify-content-between">
              <a href="https://www.facebook.com" target="_blank">
                <font-awesome-icon
                  :icon="['fab', 'facebook-square']"
                  style="color: lightblue; font-size: 2rem;"
                />
              </a>
              <a
                href="https://www.instagram.com/trushilpatel9898"
                target="_blank"
              >
                <font-awesome-icon
                  :icon="['fab', 'instagram-square']"
                  style="color: pink; font-size: 2rem;"
                />
              </a>
              <a href="https://www.twitter.com/trushilpatel989" target="_blank">
                <font-awesome-icon
                  :icon="['fab', 'twitter-square']"
                  style="color: lightblue; font-size: 2rem;"
                />
              </a>
              <a href="https://www.reddit.com/trushil" target="_blank">
                <font-awesome-icon
                  :icon="['fab', 'reddit-square']"
                  style="color: rgb(216 75 75); font-size: 2rem;"
                />
              </a>
              <a href="https://www.github.com/trushilpatel9898" target="_blank">
                <font-awesome-icon
                  :icon="['fab', 'github-square']"
                  style="color: darkgray; font-size: 2rem;"
                />
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./about.component.js"></script>
<style src="./about.component.css" scoped></style>
