<template>
  <div id="about" class="container-fluid ">
    <div class="border-bottom display-4 border-dark text-center ">
      About Us
    </div>

    <div class="row my-5">
      <div
        class="card col-sm-4 col-10 ml-auto mr-auto p-0 shadow-lg text-center bg-dark"
      >
        <img
          src="../../assets/trushilpatel.jpg"
          alt="Trushil Patel"
          class="my-3 card-img-top w-50 h-50 ml-auto  mr-auto mb-0 rounded-circle "
        />
        <div class="card-body ">
          <h4 class="card-title bg-dark text-white px-3">
            Trushil Patel
            <span class="d-block lead small">
              Creator Of FSM
              <img src="../../assets/FSM.png" height="30px" width="30px" />
            </span>
            <div class=" pn-3  bg-dark">
              <div class="d-flex justify-content-between">
                <a href="https://www.facebook.com" target="_blank">
                  <font-awesome-icon
                    :icon="['fab', 'facebook-square']"
                    style="color: gray; font-size: 2rem;"
                  />
                </a>
                <a href="https://www.instagram.com" target="_blank">
                  <font-awesome-icon
                    :icon="['fab', 'instagram-square']"
                    style="color: gray; font-size: 2rem;"
                  />
                </a>
                <a href="https://www.twitter.com" target="_blank">
                  <font-awesome-icon
                    :icon="['fab', 'twitter-square']"
                    style="color: gray; font-size: 2rem;"
                  />
                </a>
                <a href="https://www.reddit.com" target="_blank">
                  <font-awesome-icon
                    :icon="['fab', 'reddit-square']"
                    style="color: gray; font-size: 2rem;"
                  />
                </a>
                <a
                  href="https://www.github.com/trushilpatel9898"
                  target="_blank"
                >
                  <font-awesome-icon
                    :icon="['fab', 'github-square']"
                    style="color: gray; font-size: 2rem;"
                  />
                </a>
              </div>
            </div>
          </h4>

          <p class="card-text text-white  text-center text-justify">
            I have creted this website to provide the knowledge of stock market
            to indian youth...
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script src="./about.component.js"></script>
<style src="./about.component.css" scoped></style>
