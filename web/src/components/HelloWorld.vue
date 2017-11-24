<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
   
  </div>
</template>

<script>
import fetch from 'util/fetch'
export default {
  name: 'HelloWorld',
  mounted() {
    fetch
      .get('/api/app/info')
      .then(res => {
          console.log(res)
      })
      .catch(err => console.log(err))
  },
  data () {
    return {
      msg: 'Welcome to Your Vue.js Appgggg'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
