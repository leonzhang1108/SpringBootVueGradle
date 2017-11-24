<template>
  <div id="app">
    <MyMenu/>
    <div class="content-wrap">
      <Tabs :tabs='tabs' :currentPath='currentPath'/>
      <keep-alive>
        <router-view/>
      </keep-alive>
    </div>
  </div>
</template>

<script>
import MyMenu from '@/components/Menu'
import Tabs from '@/components/Tabs'
export default {
  name: 'app',
  data: function () {
    return {
      tabs: [],
      currentPath: ''
    }
  },
  components: {
    MyMenu, Tabs
  },
  watch: {
    '$route' (to, from) {
      this.currentPath = to.path
      this.tabs.push({
        name: to.name
      })
    }
  }
}
</script>

<style>
body, html {
  margin: 0;
  padding: 0;
  height: 100%;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  margin: 0 auto;
  height: 100%;
}
.content-wrap {
  margin-left: 200px;
  height: 100%;
}
.router-links a {
  display: inline-block;
  background: #e8e8e8;
  padding: 5px;
  border-radius: 5px;
  text-decoration: none;
  color: #000;
  width: 100px;
}
.router-links a.router-link-active {
  background-color: #3affff;
}
</style>
