<template>
  <div id="about" class="container-fluid  pb-5">
    <div class="ml-auto mr-auto">
      <div
        class="border-bottom display-4 border-dark text-center  ml-auto mr-auto text-dark"
      >
        About Us
      </div>

      <div class="my-5">
        <div
          class="card col-md-6 ml-auto mr-auto p-0 shadow-lg text-center bg-dark"
        >
          <img
            src="../../assets/trushilpatel.jpg"
            alt="Trushil Patel"
            class="my-3 card-img-top w-50 h-50 ml-auto  mr-auto mb-0 rounded-circle "
          />
          <div class="card-body ">
            <h4 class="card-title bg-dark text-white px-3 border-bottom pb-3">
              <span class="d-inline-block pb-2 border-bottom"
                >Trushil Patel</span
              >
              <span class="d-block lead small py-3 text-small">
                Creator Of FSM
                <img
                  src="../../assets/FSM.png"
                  class="ml-2"
                  height="20px"
                  width="20px"
                />
              </span>
              <div class=" pn-3  bg-dark">
                <div class="d-flex justify-content-between">
                  <a href="https://www.facebook.com" target="_blank">
                    <font-awesome-icon
                      :icon="['fab', 'facebook-square']"
                      style="color: lightblue; font-size: 2rem;"
                    />
                  </a>
                  <a href="https://www.instagram.com/trushilpatel9898" target="_blank">
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
                  <a
                    href="https://www.github.com/trushilpatel9898"
                    target="_blank"
                  >
                    <font-awesome-icon
                      :icon="['fab', 'github-square']"
                      style="color: darkgray; font-size: 2rem;"
                    />
                  </a>
                </div>
              </div>
            </h4>

            <p class="card-text text-white  text-center text-justify">
              I have created this website during the training at
              <a href="https://www.argusoft.com">Argusoft</a>
            </p>
            <p class="card-text text-white  text-center text-justify">
              Under the guidance of
              <span class="text-success">Shifa Salheen</span> ma'am and
              <span class="text-success">Maulik Desai</span> sir
            </p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./about.component.js"></script>
<style src="./about.component.css" scoped></style>
