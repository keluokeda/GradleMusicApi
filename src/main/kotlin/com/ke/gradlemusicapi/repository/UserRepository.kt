package com.ke.gradlemusicapi.repository

import com.ke.gradlemusicapi.entity.document.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CoroutineCrudRepository<User, Long>