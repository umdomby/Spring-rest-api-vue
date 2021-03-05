<template>
  <div>
    <div v-if="!profile">Необходимо авторизоваться через
      <a href="/login">Google</a>
    </div>
    <div v-else>
      <contacts-list :contacts="contacts" />
    </div>
  </div>
</template>

<script>

import ContactsList from 'components/contacts/ContactList.vue'

export default {
  name: "Contact2",
  components: {
    ContactsList
  },
  data() {
    return {
      contacts: frontendData.contacts,
      profile: frontendData.profile
    }
  }
}
</script>

<style scoped>

</style>